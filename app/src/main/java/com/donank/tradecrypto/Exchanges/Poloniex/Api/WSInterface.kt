package com.donank.tradecrypto.Exchanges.Poloniex.Api

import com.neovisionaries.ws.client.WebSocket
import com.neovisionaries.ws.client.WebSocketAdapter
import com.neovisionaries.ws.client.WebSocketException
import com.neovisionaries.ws.client.WebSocketFrame


class WSInterface : WebSocketAdapter() {
    override fun onConnectError(websocket: WebSocket?, exception: WebSocketException?) {
        super.onConnectError(websocket, exception)
    }

    override fun onDisconnected(websocket: WebSocket?, serverCloseFrame: WebSocketFrame?, clientCloseFrame: WebSocketFrame?, closedByServer: Boolean) {
        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer)
    }

    override fun onTextMessage(websocket: WebSocket?, text: String?) {
        super.onTextMessage(websocket, text)
    }

    override fun onBinaryMessage(websocket: WebSocket?, binary: ByteArray?) {
        super.onBinaryMessage(websocket, binary)
    }

    override fun onConnected(websocket: WebSocket?, headers: MutableMap<String, MutableList<String>>?) {
        super.onConnected(websocket, headers)
    }

    override fun onError(websocket: WebSocket?, cause: WebSocketException?) {
        super.onError(websocket, cause)
    }


}