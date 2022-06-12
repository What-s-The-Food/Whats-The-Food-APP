package xyz.heydarrn.whatsthefood

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xyz.heydarrn.whatsthefood.databinding.ActivityPreviewBinding
import java.io.File

class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //pemanggilan hasil foto
        val myFile = intent.getSerializableExtra("picture") as File
        val isBackCamera = intent.getBooleanExtra("isBackCamera", true)

        val result = rotateBitmap(
            BitmapFactory.decodeFile(myFile.path),
            isBackCamera
        )
        binding.imgPreview.setImageBitmap(result)

        binding.btnSearch.setOnClickListener {
            startActivity(
                Intent(this,FoodPredictionResultActivity::class.java)
                    .putExtra("photo", myFile)
            )
        }
    }

    companion object {
        const val CAMERA_X_RESULT = 200
    }
}