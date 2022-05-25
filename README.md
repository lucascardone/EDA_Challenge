# Quoridor Bot
<h3>This project was carried out to create a bot capable of playing the board game: <a href = "https://es.wikipedia.org/wiki/Quoridor">"Quoridor"</a>. The code was written and tested in:</h3>

<div style="display: inline_block">
   <img align = "auto" src = "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
   <p align = "auto"><b>Netbeans 8.2 by <a href = "https://github.com/lucascardone">@LucasCardone.</a> This is an example of how the bot plays against itself:</b></p>
</div>
<div style="display: inline_block">
  <img align = "auto" height="300" width= "300" src="https://user-images.githubusercontent.com/89162737/170126118-2f98b09c-070f-4e05-83b2-f324937db91f.gif"/>
  <img align = "top" height="150" width= "500" src="https://github-readme-stats.vercel.app/api/top-langs/?username=lucascardone&layout=compact&langs_count=7&theme=dark"/>
</div>

## Testing
- <a href = "https://github.com/lucascardone/EDA_Challenge/tree/master/test/test">Go to test packages</a>
- 134 possible cases tested in total
- The three tested classes of implementations have 100% coverage

## Download and specs
<div>
   <p>The dependencies for the bot to be online are in the <a href = "https://github.com/lucascardone/EDA_Challenge/tree/master/libraries">libraries folder</a>. Once the     project is downloaded, these .jar dependencies must be added to the libraries folder within the project in netbeans</p>
   <p>Reminder: the version in which the bot was created is netbeans 8.2, it will not work if you try to run it with older versions</p>
   <p>The bot does not stand out for its strategic strength, it stands out for the time and dedication with which it was programmed to be as clean and maintainable as        possible</p>
</div>

## Function
The functionality of the bot is based on the analysis of the board and the return of the best action, either with a move or a block with a wall and this is done asynchronously (does not take into account previous moves)
