createMap();

async function createMap() {
    refreshRover();  

    // Obtener la informacion de los obstaculos
    var config = {
        "method": 'GET',
        "headers": {
            "content-type": 'application/json'
        }
    }
    let obstaclesResponse = await fetch('/api/obstacle/', config);
    let obstaclesJson = await obstaclesResponse.json();
    obstaclesJson.forEach(obstacle => {
        createRock(obstacle.x, obstacle.y);
    });
}

async function refreshRover() {
    // Obtener la informacion del rover
    var config = {
        "method": 'GET',
        "headers": {
            "content-type": 'application/json'
        }
    }
    let roverResponse = await fetch('/api/rover/', config);
    let roverJson = await roverResponse.json();
}

function moveRover(x, y) {
    document.getElementById("rover").style.left = (x * 100) + 'px';
    document.getElementById("rover").style.top = (y * 100) + 'px';    
}

function createRock(x, y) {
    var rock = document.createElement("img");
    rock.setAttribute("src", "images/rock.png");
    rock.classList.add("rock");
    var container = document.getElementById("container");
    container.appendChild(rock);
    rock.style.left = (x * 100) + 'px';
    rock.style.top = (y * 100) + 'px';
}

var posX = 0;
var posY = 0;

async function sendCommand(command) {
    let requestBody = {"commands" : [command]};

    var config = {
        "method": 'POST',
        "headers": {
            "content-type": 'application/json'
        },
        "body": JSON.stringify(requestBody)
    }
    await fetch('/api/rover/command/', config);
    await refreshRover();
    playMoveSound()
}

async function clickBtnForward() {
    sendCommand("F");
}

function clickBtnRotateRight() {
    sendCommand("R");
}

function clickBtnBack() {
    sendCommand("B");
}

function clickBtnRotateLeft() {
    sendCommand("L");
}

function playMoveSound() {
    var audioElement = document.createElement("audio");
    audioElement.src = "sounds/robot-moving.wav";
    audioElement.controls = true;
    audioElement.autoplay = true;
    audioElement.classList.add("audio");
    document.getElementById("container").appendChild(audioElement);
}