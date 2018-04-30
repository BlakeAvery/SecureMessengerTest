import java.io.*
import java.net.*
import java.util.*

class ServerTest constructor(public val port: Int): Runnable {
    override fun run() {
        val listen = ServerSocket(port)
        println("Waiting for connection on port $port...")
        listen.soTimeout = 0 //let's disable timeout for now
        val client = listen.accept()
        client.tcpNoDelay = true
        println("Client ${client.inetAddress} connected")
        try {
            val sender = DataOutputStream(BufferedOutputStream(client.getOutputStream()))
            val receiver = DataInputStream(BufferedInputStream(client.getInputStream()))
            var string = receiver.readBytes()
            println("Data received.")
            val b64 = Base64.getDecoder()
            println("Data is:")
            println(String(b64.decode(string)))
            println("Sending acknowledgement.")
            sender.write(200)
        } catch(e: IOException) {
            System.err.println("Error: $e")
        }

    }
}