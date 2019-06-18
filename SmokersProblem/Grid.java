package smokersProblem;

import java.util.ArrayList;

/**
 * Created by lburka on 5/8/15.
 */
public class Grid {
    public int minimum = 0;
    public int tot = 0;
    ArrayList<int[]> nonS;
    static Smoker[][] vertexList;

    public Grid(int rows, int cols, ArrayList<int[]> coord) {
        vertexList = new Smoker[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                vertexList[r][c] = new Smoker(c, r, true, rows, cols);
            }
        }

        for (int[] each : coord) {
            vertexList[each[1]][each[0]].smoker = false;
            vertexList[each[1]][each[0]].label = "1  ";
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Smoker curr = vertexList[row][col];
                Smoker left;
                Smoker right;
                Smoker up;
                Smoker down;
                if (row == 0) {
                    up = null;
                } else {
                    up = vertexList[row - 1][col];
                }
                if (row == rows - 1) {
                    down = null;
                } else {
                    down = vertexList[row + 1][col];
                }
                if (col == 0) {
                    left = null;
                } else {
                    left = vertexList[row][col - 1];
                }
                if (col == cols - 1) {
                    right = null;
                } else {
                    right = vertexList[row][col + 1];
                }
                curr.left = left;
                curr.right = right;
                curr.up = up;
                curr.down = down;
                if (left != null) {
                    curr.neighbours.add(left);

                }
                curr.down = down;
                if (right != null) {
                    curr.neighbours.add(right);
                }
                if (up != null) {
                    curr.neighbours.add(up);
                }
                if (down != null) {
                    curr.neighbours.add(down);
                }
                //System.out.println(curr + ":  LEFT -> " + curr.left + "  RIGHT -> " + curr.right + " UP -> " + curr.up + " DOWN -> " + curr.down);
                findNearest(curr, coord);
            }
        }
    }

    public void printGrid(Smoker[][] grid) {
        Smoker parent=vertexList[vertexList.length - 1][vertexList[0].length - 1];
        while(parent!=null){
            parent.label="*  ";
            parent=parent.parent;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].end) {
                    System.out.print("E  ");
                } else if (grid[i][j].start) {
                    System.out.print("S  ");
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();

        Smoker parentR=vertexList[vertexList.length - 1][vertexList[0].length - 1];
        while(parentR!=null) {
            parentR.label = "0  ";
            parentR = parentR.parent;
        }
    }

    public void findNearest(Smoker me, ArrayList<int[]> nonSmokers) {
        nonS = nonSmokers;
        int myX = me.x;
        int myY = me.y;
        Smoker best = me;
        int minDistance = Integer.MAX_VALUE;
        for (int[] each : nonSmokers) {
            int x = vertexList[each[1]][each[0]].x;
            int y = vertexList[each[1]][each[0]].y;
            int distY = Math.max(myY - y, y - myY);
            int distX = Math.max(myX - x, x - myX);
            int dist = distY + distX;
            if (dist < minDistance) {
                minDistance = dist;
                best = vertexList[each[1]][each[0]];
            }
        }
        me.nearest = best;
        me.nearestDist = minDistance;
    }

    public void setMyExclusionZone(Smoker nonSmoker, int zone) {
        if (nonSmoker.myExclusionZone > 0) { // reset my exclusion Zone
            for (Smoker[] row : vertexList) {
                for (Smoker each : row) {
                    int dist = Math.max(each.y - nonSmoker.y, nonSmoker.y - each.y) + Math.max(each.x - nonSmoker.x, nonSmoker.x - each.x);
                    if (dist < nonSmoker.myExclusionZone) {
                        each.exclude = false;
                        each.label = "0  ";
                    }
                }
            }
        }
        if (zone > 0) {
            for (Smoker[] row : vertexList) {  // set my exclusion Zone
                for (Smoker each : row) {
                    int dist = Math.max(each.y - nonSmoker.y, nonSmoker.y - each.y) + Math.max(each.x - nonSmoker.x, nonSmoker.x - each.x);
                    if (dist < zone) {
                        each.exclude = true;
                        each.label = "0  ";
                    }
                }
            }
        }
        nonSmoker.myExclusionZone = zone;
        nonSmoker.exclude = true;
        nonSmoker.label = "N  ";
    }

    public int currentTotal(){
        ArrayList<Smoker> visited= new ArrayList<>();
        Smoker parent=vertexList[vertexList.length - 1][vertexList[0].length - 1];
        while(parent!=null){
            visited.add(parent);
            parent=parent.parent;
        }
        int total=0;
        ArrayList<Integer> totalMins= new ArrayList<>();
        for(int i=0;i<nonS.size();i++){
            Smoker end=vertexList[nonS.get(i)[1]][nonS.get(i)[0]];
            for(Smoker each: visited){
                int dist = Math.max(each.y - end.y, end.y - each.y) + Math.max(each.x - end.x, end.x - each.x);
                if(totalMins.size()!=i+1){
                    totalMins.add(dist);
                }else{
                    if(dist<totalMins.get(i)){
                        totalMins.set(i,dist);
                    }
                }
            }
        }
        for(Smoker [] row: vertexList){
            for(Smoker each: row){
                if(!visited.contains(each)){
                    each.parent=null;
                }
            }
        }
        for(int num: totalMins){
            total+=num;
        }
        return total;
    }

    public void findTotal(){
        int min=findMin();
        int oldTotal= currentTotal();
        //printGrid(vertexList);
        for(int [] each: nonS) {
            Smoker nonSmoker = vertexList[each[1]][each[0]];
            int i = min;
            i++;
            setMyExclusionZone(nonSmoker, i);
            boolean reachesEnd = hasPath();
            int newTotal = currentTotal();
            while (reachesEnd && newTotal >= oldTotal) {
                i++;
                setMyExclusionZone(nonSmoker, i);
                reachesEnd = hasPath();
                oldTotal = newTotal;
                newTotal = currentTotal();
            }
            setMyExclusionZone(nonSmoker, i - 1);
            hasPath();
        }
        System.out.println("min " + min + ", total " + oldTotal);
    }

    public boolean hasPath(){
        ArrayList<Smoker> visited=new ArrayList<> ();
        return findEnd(vertexList[0][0], visited, vertexList[vertexList.length - 1][vertexList[0].length - 1]);
    }

    public int findMin() {
        ArrayList<Smoker> visited=new ArrayList<> ();
        int i = 0;
        while (findEnd(vertexList[0][0], visited, vertexList[vertexList.length - 1][vertexList[0].length - 1])){
            i++;
            for (int[] each : nonS) {
                setMyExclusionZone(vertexList[each[1]][each[0]], i);
            }
            visited.clear();
        }
        visited.clear();
        i -= 1;
        for (int[] each : nonS) {
            setMyExclusionZone(vertexList[each[1]][each[0]], i);
        }
        findEnd(vertexList[0][0], visited, vertexList[vertexList.length - 1][vertexList[0].length - 1]);
        return i;
    }

    public boolean findEnd(Smoker curr, ArrayList<Smoker> visited, Smoker end) {
        if (curr == null) {
            return false;
        }
        visited.add(curr);
        boolean foundEnd = false;
        ArrayList<Smoker> neighbours;
        int distanceToEnd = Integer.MAX_VALUE;
        Smoker closestToEnd = null;
        neighbours = curr.getNeighbours(curr.parent);

        if (neighbours.size() < 1) {
            foundEnd = findEnd(curr.parent, visited, end);
        } else {
            for (Smoker each : neighbours) {
                if (each == end) {
                    each.parent=curr;
                    return true;
                }
                //ArrayList<Smoker> nbs = each.getNeighbours(visited.get(visited.size()-1));//has niegbours
                //System.out.println(each.y +", "+ each.x +": "  + nbs.size());
                int dist = Math.max(each.y - end.y, end.y - each.y) + Math.max(each.x - end.x, end.x - each.x);

                if (dist < distanceToEnd && !visited.contains(each)) {
                    //System.out.println(each.y +", "+ each.x);
                   // System.out.println();
                    distanceToEnd = dist;
                    closestToEnd = each;
                }
            }
            if(closestToEnd==null) {
                if(curr==vertexList[0][0]){
                    return false;
                }
                foundEnd = findEnd(curr.parent, visited, end);
            }else{
                closestToEnd.parent=curr;
                foundEnd = findEnd(closestToEnd, visited, end);
            }
        }
        return foundEnd;
    }

}
