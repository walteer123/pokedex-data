package com.walter.pokedata.di

import android.content.Context
import androidx.room.Room
import com.walter.pokedata.data.database.PokeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideConnectionStatusDao(pokeDatabase: PokeDatabase) = pokeDatabase.connectionStatusDao()

    @Singleton
    @Provides
    fun providePokeDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PokeDatabase::class.java,
        "poke_database"
    ).build()
}
