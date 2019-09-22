package com.appsinnovate.myapplication.ui.fragments.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsinnovate.myapplication.model.pack.CountriesItem;
import com.appsinnovate.myapplication.model.pack.Response;
import com.appsinnovate.myapplication.network.ApiClient;
import com.appsinnovate.myapplication.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<List<CountriesItem>> mutableLiveCountries = new MutableLiveData<>();
    public LiveData<List<CountriesItem>> liveCountries = mutableLiveCountries;
    private List<CountriesItem> countriesList = new ArrayList<>();


    public HomeViewModel() {
        ApiService service = ApiClient.getClient().create(ApiService.class);
//        disposable.add(service.getContinentsIds().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<ContinentsIdsResponseModel>() {
//                    @Override
//                    public void onSuccess(ContinentsIdsResponseModel continentsIdsResponseModel) {
//                        for (Integer id : continentsIdsResponseModel.getContinents_ids()) {
//                            disposable.add(service.getContinentsByIds(id).subscribe(DisposableSingleObserver));
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//                }));
        disposable.add(service.getContinentsByIds(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response>() {
                    @Override
                    public void onSuccess(Response continentByIdResponseModel) {
                        if (continentByIdResponseModel.getStatus() == 1) {
                            Log.e("test", continentByIdResponseModel.getStatus() + "");
                            Log.e("test", continentByIdResponseModel.getContinent().getContinentName() + " test " + continentByIdResponseModel.getContinent().getCountries());
                            countriesList.add(new CountriesItem(0, continentByIdResponseModel.getContinent().getContinentName()));
                            countriesList.addAll(continentByIdResponseModel.getContinent().getCountries());
                            mutableLiveCountries.setValue(countriesList);
                        } else {
                            Log.e("error", continentByIdResponseModel.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
