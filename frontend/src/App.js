import React from 'react'
import {over} from 'stompjs'
import SockJS from 'sockjs-client'
import Name from './elements/Name'
import Join from './elements/Join'
import Create from './elements/Create'

let stompClient = null
let number = -1
let gameCode = -1
let playerCounter = 1

const connect = ()=>{
    let Sock = new SockJS('https://mem.borodun.works/api/v1/ws')
    stompClient = over(Sock)
    stompClient.connect({},onConnected, onError)
}

const onConnected = () => {
    let chatMessage = {
        numberOfPlayer: number,
        roomId: gameCode
    };
    if (gameCode === -1) {
        stompClient.subscribe('/user/queue/create', onMessageReceived)
        stompClient.send("/app/create", {}, JSON.stringify(chatMessage))
    } else {
        stompClient.subscribe('/topic/room/' + chatMessage.roomId.toString(), onMessageReceived)
    }
}


const onMessageReceived = (payload)=>{

    let payloadData = JSON.parse(payload.body)
    console.log(payloadData)
    let chatMessage = {
        playerName: "abob",
        roomId: payloadData.roomId
    };
    gameCode = chatMessage.roomId

/*    let chatMessage2 = {
        currentPlayerNumber: 2,
        Action:"PLAYERJOIN"
    };*/
    stompClient.subscribe('/topic/room/' + chatMessage.roomId.toString(), onWaitMessageReceived())
    stompClient.send("/app/room/" + chatMessage.roomId.toString(), {}, JSON.stringify(chatMessage))
}

const onWaitMessageReceived = (payload)=>{
    let payloadData = JSON.parse(payload.body)
    console.log(payloadData)
}

const onError = (err) => {
    console.log(err)
}

const createRoom=(numberOfPlayer)=>{
    console.log("Creating room")
    number = numberOfPlayer
    connect()

}

const joinRoom=(roomId)=>{
    console.log("Joining room")
    gameCode=(roomId)
    connect()
}

const styles = {
    name: {
        textAlign: 'center',
        fontSize: '2em',
        fontWeight: 'bold',
        marginBottom: 'auto'
    }
}

function App() {
    const [name, setName] = React.useState('anonim' + playerCounter.toString())

    return (
        <div className="main">
            <p style={styles.name}>Nastolka</p>
            <Name setName={setName}/>
            <Join onJoin={joinRoom} name={name}/>
            <Create onConnect={createRoom} name={name}/>
        </div>
    )
}

export default App;
