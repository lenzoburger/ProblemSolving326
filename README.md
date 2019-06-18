# ProblemSolving326
Series of solutions to programming and mathematical problems.
Problems sets have speficic requirements as well as **time complexity (Big O)** constraints. To meet these requirements and contraints the solutions utilise; **mathematical models**, various **Data Structures**, **Graph Algorithms**, **Sorting & Searching algorithms**, **Heuristic algorithms** and **Randomized algorithms**.

### Compile
For each solution:
1. Change working directory `cd <solutionName>`
2. Compile `javac -d . *.java`
### Run
Refer to _`<solutionName>_requirement.pdf`_ for more info

**Note: With very large/complex input data increasing stack size may be required for solutions with deep recursion in order to avoid `StackOverflowError`. Via `java -Xss<size> SolutionName`

_**Carpets**_
* Usage: _`java carpets.MakeCarpet <carpetSize> <MatchType> < <carpetPieces_File>`_
  * _Example:_  `java carpets.MakeCarpet 5 -n < test\t0.txt`

_**Colour of the day**_
* Usage:  `java colourOfTheDay.GenerateCOTD` 
* Usage: `java colourOfTheDay.GenerateCOTDAlt`

_**Counting it up**_
* Usage: _`java CountingUp <deckSize n> <drawn k>`_
  * _Example:_  `java countingItUp.CountingUp 104 7`

_**Epidemic**_
* Usage: _`java epidemic.Epidemic < <universeState_File>`_
  * _Example:_  `java epidemic.Epidemic < test\d1.txt`
* Usage: _`java epidemic.EpidemicP2 < <universeState_File>`_
  * _Example:_ `java epidemic.EpidemicP2 < test\d0.txt`

_**Counting it up**_
* Usage: _`java CountingUp <deckSize n> <drawn k>`_
  * _Example:_  `java countingItUp.CountingUp 104 7`

_**Numbers**_
* Usage: `java numbers.HarmonicNums`
* Usage: `java numbers.StandardDeviation`
* Usage: _`java numbers.Identity <x> <y>`_, _Example:_  `java numbers.Identity 567 674`

_**Pentonimoes**_
* Usage: _`java pentonimoes.PentominoesFill < <fillPuzzle_File>`_
  * _Example:_  `java pentonimoes.PentominoesFill < test\fill\base.txt`
* Usage: _`java pentonimoes.PentominoesSolve < <solvePuzzle_File>`_
  * _Example:_  `java pentonimoes.PentominoesSolve < test\solve\input.txt`

_**Poker**_
* Usage: _`java poker.Poker < <pokerHand_File>`_
  * _Example:_  `java poker.Poker < test\pokerInput.txt`

_**Repeated Digits**_
* Usage: _`java repeatedDigits.findBlock <base b> <integer n>`_
  * _Example:_  `java repeatedDigits.findBlock 10 30`
* Usage: _`java repeatedDigits.findRepeat <base1 b> <base2 c>`_
  * _Example:_  `java repeatedDigits.findRepeat 56 78`

_**Smoker's Problem**_
* Usage: _`java smokersProblem.SProblem < <GridInput_File>`_
  * _Example:_  `java smokersProblem.SProblem < test\big.txt`
* For Very Large Grids: _`java -Xss<size> smokersProblem.SProblem < <LARGEGridInput_File>`_
  * _Example:_  `java -Xss2M smokersProblem.SProblem < test\massive.txt`

_**Telephone Numbers**_
* Usage: _`java telephoneNumbers.TeleNumberApp < <TeleNumInput_File>`_
  * _Example:_ `java telephoneNumbers.TeleNumberApp < test\sample.txt`

_**Threes**_
* Usage: `java threes.Threes2`

_**Toothpicks**_
* Usage: _`java ToothpicksApp <generations n> <OPTIONAL: ratio r>`_
  * _Example:_ `java toothpicks.ToothpicksApp 10 0.5`

_**Word Chains**_
* Usage: _`java WordChainsApp <firstWord> <lastWord> <OPTIONAL: chainLength> < <wordsList_File>`_
  * _Example:_ `java wordChains.WordChainsApp abed bulk 500 < test\superMassive.txt`



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
