fun main(args: Array<String>) {
    val err = System.err
    val sh = ServerTest(Integer.parseInt(args[0]))
    val thread = Thread(sh)
    thread.start()
}