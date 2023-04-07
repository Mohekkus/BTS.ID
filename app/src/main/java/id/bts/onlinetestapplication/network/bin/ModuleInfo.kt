package id.bts.onlinetestapplication.network.bin

object ModuleInfo {
    private const val address = "94.74.86.174"
    private const val port = "8080"
    private const val sub = "api"

    fun getAddress() = "http://$address:$port/$sub"

    const val checklist = "/checklist"
    private const val item = "/item"

    fun getChecklistItemById(id: Int) = "$checklist/$id/$item"
    fun doWithCheckListItem(id: Int) = getChecklistItemById(id)
}