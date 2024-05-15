package com.walter.pokedata.di

import androidx.room.Room
import com.walter.pokedata.data.dao.ConnectionStatusDao
import com.walter.pokedata.data.database.PokeDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            PokeDatabase::class.java,
            "poke_database"
        ).build()
    }

    single<ConnectionStatusDao> { get<PokeDatabase>().connectionStatusDao() }
}
