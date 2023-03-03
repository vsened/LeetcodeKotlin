import uniqueEmailAddresses.UniqueEmailAddresses

fun main(args: Array<String>) {
    val emails = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val test = UniqueEmailAddresses().numUniqueEmails(emails)
    println(test)
}