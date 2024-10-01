class NoteApplication {
    private val archive = Archive()

    fun start() {
        println("Начало программы")
        while (true) {
            displayMainMenu()
            when (readLine()) {
                "1" -> createArchive()
                "2" -> openArchive()
                "3" -> {
                    println("Выход из программы")
                    return
                }
                else -> {
                    println("Некорректный ввод, введите цифру 1, 2 или 3.")
                }
            }
        }
    }

    private fun displayMainMenu() {
        println("Выберите действие:")
        println("1. Создать архив")
        println("2. Открыть архив")
        println("3. Выход")
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val archiveName = readLine()?.trim() ?: ""
        if (archiveName.isEmpty()) {
            println("Имя архива не может быть пустым или состоять только из пробелов.")
            return
        }
        archive.createArchive(archiveName)
    }

    private fun openArchive() {
        println("Выберите архив:")
        val archives = archive.listArchives()
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
            return
        }
        archives.forEachIndexed { index, name -> println("${index + 1}. $name") }

        while (true) {
            println("Введите номер архива:")
            val choice = readLine()?.toIntOrNull()
            if (choice == null) {
                println("Ошибка: необходимо ввести цифру.")
            } else if (choice in 1..archives.size) {
                val selectedArchive = archives[choice - 1]
                archive.openArchive(selectedArchive)
                break
            } else {
                println("Ошибка: архива с таким номером не существует.")
            }
        }
    }
}