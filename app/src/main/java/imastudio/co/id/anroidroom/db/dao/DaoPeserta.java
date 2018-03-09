package imastudio.co.id.anroidroom.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import imastudio.co.id.anroidroom.db.model.ModelPeserta;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DaoPeserta {
    @Query("select * from peserta")
    LiveData<List<ModelPeserta>> getAllPeserta();

    @Query("select * from peserta where id_peserta = :id")
    ModelPeserta getPeserta(String id);

    @Insert(onConflict = REPLACE)
    void addPeserta(ModelPeserta modelPeserta);

    @Delete()
    void deletePeserta(ModelPeserta modelPeserta);
}
