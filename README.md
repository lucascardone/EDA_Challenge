<h1>Quoridor Bot</h1>

<h3><a href = "https://es.wikipedia.org/wiki/Quoridor">Quoridor</a> bot developed for EDA nº6 (Engineering Development Academy) of the company <a href="https://es.wikipedia.org/wiki/Eventbrite">Eventbrite.</a></h3>

<h2>Author</h2>
<div>
   <ul>
      <li><p><a href = "https://github.com/lucascardone"><b>@LucasCardone</b></a></p></li>
      <li><p>Developed and tested in: </p><img align = "auto" src = "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"></li>
      <li><p><b>IDE:</b> Netbeans 8.2, do not download if your version is older than this.</p></li>
      <li><p><a href = "https://github.com/lucascardone/EDA_Challenge/tree/master/libraries"><b>Dependencies: </b></a>javax.websocket-client-api-1.1, gson-2.9.0, lombok-1,18.24, tyrus-standalone-client-1.9</p></li>
   </ul>   
</div>

<h2>General</h2>

<p>
   The bot was programmed to be as clean and maintainable as possible over time. Due to this, the bot strategy is not its strong point, however, at the time it gave very good results.
</p>
<p>This is an example of how the bot plays against itself:</p>   
   
<div style="display: inline_block">
  <img align = "auto" height="300" width= "300" src="https://user-images.githubusercontent.com/89162737/170126118-2f98b09c-070f-4e05-83b2-f324937db91f.gif"/>
</div>

<h2>Unit Test</h2>
<ul>
   <li><p><a href = "https://github.com/lucascardone/EDA_Challenge/tree/master/test/test">Go to test packages</a></p></li>
   <li><p>134 possible cases tested in total</p></li>
   <li><p>The three tested classes of implementations have 100% coverage</p></li>
   <li><p>A 5x5 scale board was used for a better reading of them.</p></li>
</ul>   

<h2>Connection and Download</h2>

<div>
   <h4>Connection</h4>
   <p>For the connection, the <a href = "https://es.wikipedia.org/wiki/WebSocket"><b>WebSockets</b></a> were used.</p>
   <h4>Download</h4>
   <p>Once the project is downloaded, to connect it to the WebSocket, you must add the dependencies that come within the project in the folder called <a href = "https://github.com/lucascardone/EDA_Challenge/tree/master/libraries">libraries.</a> These dependencies are added within the IDE in our "quoridorBot" project, where the .jar must be added in the libraries folder.</p>
</div>   

<h2>Specs</h2>

<div>
   <h4>STRATEGY</h4>
   <p>The strategy implemented for the <b>Attack</b> was to take a pawn and move it to the point where it crowns or gets stuck, the latter was solved by moving another that was free. For <b>Defense</b>, the use of only horizontal walls was implemented with the function of delaying the enemy pawn and that this would give our pawn time to continue advancing.</p>
   <h4>JAVA</h4>
   <p>The bot was developed in java because it is currently the only programming language that I know enough to carry out a project like this.</p>
</div>

<h2>Thanks for reading 😃</h2>
<img src = "https://img.shields.io/github/watchers/lucascardone/EDA_Challenge.svg"></img>
