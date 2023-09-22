package com.drdisagree.iconify.ui.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.drdisagree.iconify.R;
import com.drdisagree.iconify.databinding.ActivityProgressBarBinding;
import com.drdisagree.iconify.ui.adapters.ProgressBarAdapter;
import com.drdisagree.iconify.ui.models.ProgressBarModel;
import com.drdisagree.iconify.ui.utils.ViewHelper;
import com.drdisagree.iconify.ui.views.LoadingDialog;

import java.util.ArrayList;

public class ProgressBar extends BaseActivity {

    private ActivityProgressBarBinding binding;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProgressBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Header
        ViewHelper.setHeader(this, binding.header.toolbar, R.string.activity_title_progress_bar);

        // Loading dialog while enabling or disabling pack
        loadingDialog = new LoadingDialog(this);

        // RecyclerView
        binding.progressbarContainer.setLayoutManager(new LinearLayoutManager(this));
        binding.progressbarContainer.setAdapter(initProgressBarItems());
        binding.progressbarContainer.setHasFixedSize(true);
    }

    private ProgressBarAdapter initProgressBarItems() {
        ArrayList<ProgressBarModel> pgb_list = new ArrayList<>();

        pgb_list.add(new ProgressBarModel("Default", R.drawable.preview_seekbar_default));
        pgb_list.add(new ProgressBarModel("Divided", R.drawable.preview_seekbar_divided));
        pgb_list.add(new ProgressBarModel("Gradient Thumb", R.drawable.preview_seekbar_gradient_thumb));
        pgb_list.add(new ProgressBarModel("Minimal Thumb", R.drawable.preview_seekbar_minimal_thumb));
        pgb_list.add(new ProgressBarModel("Blocky Thumb", R.drawable.preview_seekbar_blocky_thumb));
        pgb_list.add(new ProgressBarModel("Outline Thumb", R.drawable.preview_seekbar_outline_thumb));
        pgb_list.add(new ProgressBarModel("Oldschool Thumb", R.drawable.preview_seekbar_oldschool_thumb));
        pgb_list.add(new ProgressBarModel("No Thumb", R.drawable.preview_seekbar_no_thumb));
        pgb_list.add(new ProgressBarModel("Thin Track", R.drawable.preview_seekbar_thin_track));
        pgb_list.add(new ProgressBarModel("Inline", R.drawable.preview_seekbar_inline));
        pgb_list.add(new ProgressBarModel("Lighty", R.drawable.preview_seekbar_lighty));

        return new ProgressBarAdapter(this, pgb_list, loadingDialog);
    }

    @Override
    public void onDestroy() {
        loadingDialog.hide();
        super.onDestroy();
    }
}