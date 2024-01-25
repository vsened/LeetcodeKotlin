package uniqueEmailAddresses

/**
 * Unique Email Addresses.
 * Every valid email consists of a local name and a domain name, separated by the '@' sign.
 * Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 * - For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 *
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there
 * will be forwarded to the same address without dots in the local name. Note that this rule does not apply
 * to domain names.
 *
 * - For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 *
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows
 * certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 * - For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given an array of strings emails where we send one email to each emails[i], return the number of different
 * addresses that actually receive mails.
 * */
class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val dict = emptyMap<String, Int>().toMutableMap()
        for (email in emails) {
            var currentEmail = email.split("@")
            println(currentEmail)
            var name = currentEmail[0].replace(".", "").split('+')
            println(name)
            var clearEmail = "${name[0]}@${currentEmail[1]}"
            println(clearEmail)
            if (!dict.containsKey(clearEmail)) {
                dict.put(clearEmail, 1)
            }
        }
        return dict.size
    }

    fun numUniqueEmails2(emails: Array<String>): Int {
        val uniqueEmails = HashSet<String>()
        for (email in emails) {
            val currentEmail = email.split("@")
            val user = currentEmail[0].split("+")[0].replace(".", "").lowercase() +
                    "@${currentEmail[1]}"
            uniqueEmails.add(user)
        }
        return uniqueEmails.size
    }

    fun numUniqueEmails3(emails: Array<String>): Int {
        val set = mutableSetOf<String>()
        for (email in emails) {
            set.add(normalize(email))
        }
        return set.size
    }

    private fun normalize(email: String): String {
        return buildString {
            var i = 0
            while (i < email.length) {
                when (email[i]) {
                    '.' -> {}
                    '@', '+' -> break
                    else -> append(email[i])
                }
                i++
            }
            while (i < email.length) {
                if (email[i] == '@') break
                i++
            }
            appendRange(email, i, email.length)
        }
    }

}