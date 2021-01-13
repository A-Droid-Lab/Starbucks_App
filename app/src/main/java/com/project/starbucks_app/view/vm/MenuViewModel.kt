package com.project.starbucks_app.view.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.repository.StarbucksRepository
import com.project.starbucks_app.view.base.BaseViewModel
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val repo : StarbucksRepository) : BaseViewModel(){

    private val _coffeeLiveData = MutableLiveData<List<MenuItem>>()
    val coffeeLiveData : LiveData<List<MenuItem>>
        get() = _coffeeLiveData

    private val _frapuccinoLiveData = MutableLiveData<List<MenuItem>>()
    val frapuccinoLiveData : LiveData<List<MenuItem>>
        get() = _frapuccinoLiveData

    private val _blendedLiveData = MutableLiveData<List<MenuItem>>()
    val blendedLiveData : LiveData<List<MenuItem>>
        get() = _blendedLiveData


    fun getCoffeeMenu(){
        addDisposable(
            repo.getCoffeeMenu()
                .subscribe({
                    _coffeeLiveData.postValue(it)
                    it.forEach { Log.d("커피 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }

    fun getFrapuccinoMenu(){
        addDisposable(
            repo.getFrapuccino()
                .subscribe({
                    _frapuccinoLiveData.postValue(it)
                    it.forEach { Log.d("프라푸치노 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }

    fun getBlendedMenu(){
        addDisposable(
            repo.getBlended()
                .subscribe({
                    _blendedLiveData.postValue(it)
                    it.forEach { Log.d("블랜디드 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }


    //커피
    //249 - 295

    //프라푸치노
    //296 - 311

    //블렌디드
    //312 - 320

    // 과일 음료 & 티
    // 321 - 358

    // 시그니처
    // 359 - 377

    //주스
    //378 - 384

    //요거트
    //385 - 386

    // 빵 류 (베이크 파이 크로와
    // 405상 - 414

    //케이크
    //415 - 448

    //샌드위치, 빵, 수프
    // 449 - 486

    // 과일 관련 상품 (유자청, 한컵)
    // 487 - 492

    // 푸딩 요거트
    // 493 - 496

    //카스테라 초콜릿 쿠키 마카롱 젤리 캔디
    //498 - 536

    // 아이스크림
    // 537 - 546

    // 프로모션 상품 머그
    // 547 - 597


    //텀블러
    // 619 ~ 627
    // 649 ~ 680

    // 컵 md 상
    // 606 - 618
    // 628 ~ 648

    // 보온병
    // 687  ~ 695

    // 우산 에코백
    // 696 - 756

    // 케이크 (포장용)
    // 757 - 763

}