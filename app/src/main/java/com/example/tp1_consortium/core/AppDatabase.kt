package com.example.tp1_consortium.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tp1_consortium.domain.models.models.Delivery
import com.example.tp1_consortium.domain.models.repositories.DeliveryRepository
import java.util.concurrent.Executors

@Database(entities = [Delivery::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    //Changer la ligne ici: dans le TP DeliveryRepository
    abstract fun noteRepository(): DeliveryRepository

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?:
            synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "notes") //notes = nom du fichier sql dans le téléphone
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        ioThread {
                            //Ajouter les données de démarrage
                        }
                    }
                })
                .build()

        /**
         * Utility method to run blocks on a dedicated background thread, used for io/database work.
         */
        private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
        fun ioThread(f: () -> Unit) {
            IO_EXECUTOR.execute(f)
        }
    }
}