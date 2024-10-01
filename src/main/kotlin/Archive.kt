class Archive {
    private val archives = mutableMapOf<String, MutableList<Note>>()

    fun createArchive(name: String) {
        if (archives.containsKey(name)) {
            println("Архив с таким именем уже существует.")
        } else {
            archives[name] = mutableListOf()
            println("Архив '$name' создан.")
        }
    }

    fun listArchives(): List<String> {
        return archives.keys.toList()
    }

    fun openArchive(name: String) {
        println("Вы открыли архив '$name'")
        val noteManager = NoteManager(archives[name]!!)
        noteManager.manageNotes()
    }
}