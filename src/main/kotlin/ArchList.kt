import kotlin.system.exitProcess

class ArchList : Commander() {
    private var archMenu: MutableMap<Int, Archive> = HashMap()

    private fun addArch() {
        println("Введите имя нового архива:")
        val n = readLine()!!
        val a = Archive(n, NoteList())
        archMenu[(archMenu.size + 1)] = a
        printing()
    }

    override fun command() {
        choice = commandReader()
        when (choice) {
            0 -> addArch()
            menuNumb -> exitProcess(1)
            else -> if (archMenu.contains(choice)) archMenu[choice]?.noteMenu?.printing() else println(
                "Архива с выбранным номером не существует"
            )
        }
    }
}

