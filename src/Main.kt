fun main(args: Array<String>) {
    val sh = ServerTest(Integer.parseInt(args[0]))
    val thread = Thread(sh)
    thread.start()
}