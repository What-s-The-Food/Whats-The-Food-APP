package xyz.heydarrn.whatsthefood

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val isBackCamera = intent.getBooleanExtra("isBackCamera", true) as Boolean

        val result = rotateBitmap(
            BitmapFactory.decodeFile(myFile.path),
            isBackCamera
        )
        binding.imgPreview.setImageBitmap(result)

        binding.btnSearch.setOnClickListener {
            Toast.makeText(this, "Button ditekan", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val CAMERA_X_RESULT = 200

    }
}