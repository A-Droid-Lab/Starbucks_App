package com.project.starbucks_app.repository

import com.project.starbucks_app.data.local.dao.StarbucksDao
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.data.remote.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StarbucksRepository @Inject constructor(private val apiService: ApiService, private val starbucksDao: StarbucksDao) {

    fun getCoffeeMenu() : Single<List<MenuItem>> {
        return apiService.getAllMenus()
                .subscribeOn(Schedulers.io()) //Observable이 발행되는 스레드를 지정한다. 여기선 네트워크 통신으로 io 스레드에서 하겠다는 것.
                .observeOn(AndroidSchedulers.mainThread()) //처리된 결과를 전달하는 스레드 지정한다. = 워크 스레드에서 데이터를 가져오지만 가져온 데이터 구독은 메인 스레드에서 하겠다.
                .toObservable() // Single을 Observable로 변환하며 변환된 Observable은 Single이 배출 할 항목을 배출한 후 종료된다
                .flatMapIterable {
                    it.filter { t -> t.id in 249..295 }
                }
                .toList() // Observable의 toList는 Single을 반환한다.
        // concatMap, switchMap, flatMap
        // concatMap = 순서를 보장하지만 동기라서 느리다.
        // flatMap = 순서를 보장하지 못하지만 비동기라서 빠르다.
        // switchMap = 이전에 구독하던 것을 해지하고 늘 최신만을 구독한다.
    }

    fun getFrapuccino() : Single<List<MenuItem>> {
        return apiService.getAllMenus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .flatMapIterable {
                it.filter { t -> t.id in 296..311 }
            }
            .toList()
    }

    fun getBlended(): Single<List<MenuItem>> {
        return apiService.getAllMenus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .flatMapIterable {
                it.filter { t -> t.id in 312..320 }
            }
            .toList()
    }

    fun getAllCoffeeMenu() : Single<List<MenuItem>>{
        return apiService.getAllMenus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .flatMapIterable {
                    it.filter { t -> t.id in 249..320 }
                }
                .toList()
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