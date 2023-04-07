package id.bts.onlinetestapplication.network.bin

data class NetworkServiceHandler<out T>(
    val status: NetworkStatus,
    val data: T?,
    val message:String?
){
    companion object{

        fun <T> success(data:T?): NetworkServiceHandler<T> {
            return NetworkServiceHandler(
                NetworkStatus.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(msg:String, data:T?): NetworkServiceHandler<T> {
            return NetworkServiceHandler(
                NetworkStatus.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data:T?): NetworkServiceHandler<T> {
            return NetworkServiceHandler(
                NetworkStatus.LOADING,
                data,
                null
            )
        }

    }
}