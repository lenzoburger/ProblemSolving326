# ProblemSolving326
Series of solutions to programming and mathematical problems

### Compile
For each solution:
1. Change working directory `cd [solutionName]`
2. Compile `javac -d . *.java`
### Run
Refer to _`[solutionName]_requirement.pdf`_ for more info

_**Carpets**_
* Usage: _`java carpets.MakeCarpet [carpetSize] [MatchType] < [Input/File]`_
  * _e.g._ `java carpets.MakeCarpet 5 -n < test\t0.txt`

_**Colour of the day**_
* Usage:  `java colourOfTheDay.GenerateCOTD` 
* Usage: `java colourOfTheDay.GenerateCOTDAlt`

_**Counting it up**_
* Usage: _`java CountingUp [deckSize n] [drawn k]`_
  * _e.g._ `java countingItUp.CountingUp 104 7`

_**Epidemic**_
* Usage: _`java epidemic.Epidemic < [Input/File]`_
  * _e.g._ `java epidemic.Epidemic < test\d1.txt`
* Usage: _`java epidemic.EpidemicP2 < [Input/File]`_
  * _e.g._`java epidemic.EpidemicP2 < test\d0.txt`

_**Counting it up**_
* Usage: _`java CountingUp [deckSize n] [drawn k]`_
  * _e.g._ `java countingItUp.CountingUp 104 7`

_**Numbers**_
* Usage: `java numbers.HarmonicNums`
* Usage: `java numbers.StandardDeviation`
* Usage: _`java numbers.Identity [x] [y]`_, _e.g._ `java numbers.Identity 567 674`

_**Pentonimoes**_
* Usage: _`java pentonimoes.PentominoesFill < [fillPuzzle]`_
  * _e.g._ `java pentonimoes.PentominoesFill < test\fill\base.txt`
* Usage: _`java pentonimoes.PentominoesSolve < [solvePuzzle]`_
  * _e.g._ `java pentonimoes.PentominoesSolve < test\solve\input.txt`

_**Poker**_
* Usage: _`java poker.Poker < [input/file]`_
  * _e.g._ `java poker.Poker < test\pokerInput.txt`

## Development
#### Dependencies
1. [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

#### Tools
1. [Git](https://git-scm.com/downloads)
2. [Visual Studio Code](https://code.visualstudio.com/download) + **Extensions:**
   * [_Java Extension Pack_](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   * [_vscode-pdf_](https://marketplace.visualstudio.com/items?itemName=tomoki1207.pdf)
   * [_Markdown All in One_](https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one)
   * [_Markdown Preview Enhanced_](https://marketplace.visualstudio.com/items?itemName=shd101wyy.markdown-preview-enhanced)
   * [_Meterial Icon Theme_](https://marketplace.visualstudio.com/items?itemName=PKief.material-icon-theme)
   * [_Path Intellisense_](https://marketplace.visualstudio.com/items?itemName=christian-kohler.path-intellisense)
### Setup

#### Install dependencies
1. Install [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Ensure Java/JDK is included in PATH & set JAVA_HOME variable

#### Clone & Run
1. Clone repo: `git clone https://github.com/lenzoburger/ProblemSolving326.git`
2. Launch Terminal/CMD
3. [Compile](#compile) & [Run](#ru) solutions
