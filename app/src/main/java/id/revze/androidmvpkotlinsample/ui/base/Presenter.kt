package id.revze.androidmvpkotlinsample.ui.base

interface Presenter<T : View> {
    fun onDetach()
}