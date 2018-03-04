import java.util.*

/**
 * Created by akac on 16/02/2018.
 */

class Note(var title: String, var description: String)

class NoteGenerator {
    companion object {
        fun loadNotes(): ArrayList<Note> {
            var notes: ArrayList<Note> = ArrayList<Note>()
            if (notes.size == 0) {
                for (i in 0..29) {
                    val title = _randomText(15, true)
                    val description = _randomText(100, false)

                    notes.add(Note(title, description))
                }
            }
            return notes
        }

        private fun _randomText(maxLenght: Int, isTitle: Boolean): String {
            val generator = Random()
            val randomStringBuilder = StringBuilder()
            val randomLength = generator.nextInt(maxLenght) + 1
            var tempChar: Char
            if (isTitle) {
                tempChar = (generator.nextInt(25) + 65).toChar()
                randomStringBuilder.append(tempChar)
            }
            for (i in 0 until randomLength) {
                tempChar = (generator.nextInt(25) + 97).toChar()
                randomStringBuilder.append(tempChar)
                if (generator.nextInt(6) % 6 == 0) {
                    randomStringBuilder.append(' ')
                }
            }

            return randomStringBuilder.toString()
        }
    }
}