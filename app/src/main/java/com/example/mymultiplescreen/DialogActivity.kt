package com.example.mymultiplescreen

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.mymultiplescreen.databinding.ActivityDialogBinding

class PlayGroundActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeDialog()

        binding.btnRequestPermission.setOnClickListener {
            requestPermission()
            Toast.makeText(this, "helo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestPermission() {

        var permissionsToRequest = mutableListOf<String>()

        if (!hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (!hasLocationForegroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (!hasLocationBackgroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "${permissions[i]} granted")
                }
            }
        }
    }

    private fun hasWriteExternalStoragePermission(): Boolean {
        Toast.makeText(this, "permission btn clicked", Toast.LENGTH_SHORT).show()
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }


    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED


    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED


    private fun makeDialog() {
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add me to your contact list")
            .setIcon(R.drawable.grapes)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You clicked yes !!!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You clicked no !!!", Toast.LENGTH_SHORT).show()
            }.create()

        val options = arrayOf("First item", "Second item", "Third item")

        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the items")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined", Toast.LENGTH_SHORT).show()
            }.create()

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the items")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btn1.setOnClickListener {
            addContactDialog.show()
        }

        binding.btn2.setOnClickListener {
            singleChoiceDialog.show()
        }

        binding.btn3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}