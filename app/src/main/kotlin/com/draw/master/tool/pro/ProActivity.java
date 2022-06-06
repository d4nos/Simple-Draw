package com.draw.master.tool.pro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.draw.master.tool.BuildConfig;
import com.draw.master.tool.R;

import java.util.Locale;

public class ProActivity extends ProBaseActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ProActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        findViewById(R.id.bt_close).setOnClickListener(view -> finish());
        ProHelper.getInstance().initBilling(this, new BillingClientStateListener() {
            @Override
            public void onBillingServiceDisconnected() {

            }

            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                runOnUiThread(() -> initPack());
            }
        });
    }

    private void initPack() {
        ProHelper pHelper = ProHelper.getInstance();
        for (int i = 1; i <= 4; i++) {
            try {
                View layoutPack = findViewByName("layout_pack_" + i);
                layoutPack.setSelected(true);
                String packString = BuildConfig.DEBUG ? ProHelper.DRAW_PRO_TEST : "pack_" + i;
                layoutPack.setOnClickListener(view -> {
                    pHelper.purchase(this, packString);
                });

                String titleViewIdString = String.format(Locale.US, "tv_pack_%d_price", i);
                TextView tvPrice = (TextView) findViewByName(titleViewIdString);
                tvPrice.setSelected(layoutPack.isSelected());
                String price = ProHelper.getInstance().getPrice(packString);
                tvPrice.setText(price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private View findViewByName(String viewIdString) {
        return findViewById(getResources().getIdentifier(viewIdString, "id", getPackageName()));
    }


    @Override
    protected int onLayout() {
        return R.layout.activity_pro;
    }
}
