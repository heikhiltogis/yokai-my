package tachiyomi.core.provider

import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import java.io.File
import org.nekomanga.core.BuildConfig
import org.nekomanga.core.R

class AndroidStorageFolderProvider(
    private val context: Context,
) : FolderProvider {

    override fun directory(): File {
        return File(
            Environment.getExternalStorageDirectory().absolutePath +
                File.separator +
                when (BuildConfig.DEBUG) {
                    true -> context.getString(R.string.app_name_neko) + "_debug"
                    false -> context.getString(R.string.app_name_neko)
                }
        )
    }

    override fun path(): String {
        return directory().toUri().toString()
    }
}
