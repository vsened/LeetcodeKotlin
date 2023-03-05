package studentAttendanceRecord1
/**
 * Student Attendance Record I.
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 */
class StudentAttendanceRecord1 {
    /**
     * Using loop
     */
    fun checkRecord(s: String): Boolean {
        var a = 0
        var l = 0
        for (i in s.indices) {
            when (s[i]){
                'A' -> {
                    if (++a == 2)
                        return false
                    l = 0
                }
                'L' ->
                    if (++l == 3)
                        return false
                else -> l = 0
            }
        }
        return true
    }
    /**
     * Using string's methods
     */
    fun checkRecord2(s: String): Boolean {
        return (s.length - s.replace("A","").length < 2)
                && !s.contains("LLL")
    }
}