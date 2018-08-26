package id.revze.androidmvpkotlinsample.views.base

interface Presenter<T : View> {
    fun onAttach(view: T)

    fun onDetach()
}