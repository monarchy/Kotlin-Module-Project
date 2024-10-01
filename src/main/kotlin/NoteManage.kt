class NoteManager(private val notes: MutableList<Note>) {
    fun manageNotes() {
        while (true) {
            displayNoteMenu()
            when (readLine()) {
                "1" -> createNote()
                "2" -> viewNotes()
                "3" -> return
                else -> println("Некорректный ввод, попробуйте еще раз.")
            }
        }
    }

    private fun displayNoteMenu() {
        println("Выберите действие:")
        println("1. Создать заметку")
        println("2. Просмотреть заметки")
        println("3. Выход")
    }

    private fun createNote() {
        println("Введите заголовок заметки:")
        val title = readLine() ?: ""
        if (title.isEmpty()) {
            println("Заголовок не может быть пустым.")
            return
        }
        println("Введите содержание заметки:")
        val content = readLine()?.trim() ?: ""
        if (content.isEmpty()) {
            println("Содержание не может быть пустым или состоять только из пробелов.")
            return
        }
        val note = Note(title, content)
        notes.add(note)
        println("Заметка '$title' создана.")
    }

    private fun viewNotes() {
        if (notes.isEmpty()) {
            println("Заметок нет.")
        } else {
            notes.forEach { println(it) }
        }
    }
}