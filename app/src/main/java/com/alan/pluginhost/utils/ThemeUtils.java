package com.alan.pluginhost.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import androidx.annotation.ColorRes;

import com.alan.pluginhost.Const;
import com.alan.pluginhost.HostApp;
import com.alan.pluginhost.MainActivity;
import com.alan.pluginhost.R;
import com.alan.pluginhost.helper.MDTintHelper;

import java.util.ArrayList;
import java.util.List;


public class ThemeUtils {

    public static final String TAG = "ThemeUtils";
    private static final String THEME = "pre_theme";

    public static void changeTheme(Activity activity) {
        final ChoiceOnClickListener listener = new ChoiceOnClickListener();
        final int index = getThemeIndex(getTheme(activity).tag);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.theme)
                .setSingleChoiceItems(new TAdapter(activity, R.layout.item_theme, android.R.id.text1, Theme.getThemes()), index, listener)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Theme theme = Theme.getThemes().get(listener.getWhich());
                        setTheme(activity, theme);

                        activity.startActivity(new Intent(activity, MainActivity.class));
                        activity.finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    /**
     * @param activity
     */
    public static void setTheme(Activity activity) {
        setTheme(activity, getTheme(activity));
    }

    /**
     * @param activity
     * @param theme
     */
    public static void setTheme(Activity activity, Theme theme) {
        if (theme == null) {
            return;
        }
        activity.setTheme(theme.style);
        saveTheme(activity, theme);
    }

    /**
     * @return
     */
    public static int getThemeCount() {
        return Theme.getThemes().size();
    }

    /**
     * @param theme
     */
    private static void saveTheme(Context context, Theme theme) {
        SharedPreferences preferences = context.getSharedPreferences(Const.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(THEME, theme.tag);
        editor.commit();
    }

    /**
     * @param context
     * @return
     */
    public static Theme getTheme(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Const.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String tag = preferences.getString(THEME, Theme.getThemes().get(0).tag);
        return getThemeByTag(tag);
    }

    /**
     * @param tag
     * @return
     */
    private static Theme getThemeByTag(String tag) {
        for (Theme t : Theme.getThemes()) {
            if (t.tag.equals(tag)) {
                return t;
            }
        }
        return Theme.getThemes().get(0);
    }

    /**
     * @param tag
     * @return
     */
    private static int getThemeIndex(String tag) {
        for (int i = 0; i < Theme.getThemes().size(); i++) {
            if (Theme.getThemes().get(i).tag.equals(tag)) {
                return i;
            }
        }
        return 0;
    }

    /**
     *
     */
    private static class ChoiceOnClickListener implements DialogInterface.OnClickListener {

        private int which = 0;

        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            this.which = which;
        }

        public int getWhich() {
            return which;
        }
    }


    /**
     * Theme
     */
    public static class Theme {
        public String name;
        public String tag;
        public int color;
        public int style;

        private static List<Theme> THEME_MAP = new ArrayList<>();


        public Theme(String name, String tag, @ColorRes int color, int style) {
            this.name = name;
            this.tag = tag;
            this.color = color;
            this.style = style;
        }

        protected static List<Theme> getThemes() {
            return THEME_MAP;
        }

        @Override
        public String toString() {
            return name;
        }
    }

//    public static View ThemeDialogView(Context context) {
////        mContext = context;
//        RelativeLayout layout = new RelativeLayout(context);
//
//        LinearLayoutManager lm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//
//        ObservableList<Theme> data = new ObservableArrayList<>();
//        data.addAll(Theme.getThemes());
//        RecyclerView recyclerView = new RecyclerView(context);
//        recyclerView.setLayoutManager(lm);
//        ThemeAdapter adapter = new ThemeAdapter(context, data);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//        layout.addView(recyclerView);
////            RxRecyclerView.scrollEvents()
//        return layout;
//    }

//    private static class ThemeDialogView {
//
//        private Context mContext;
//
//        public ThemeDialogView(Context context) {
//            mContext = context;
//            ObservableList<Theme> data = new ObservableArrayList<>();
//            data.addAll(Theme.getThemes());
//            RecyclerView recyclerView = new RecyclerView(getContext());
//            ThemeAdapter adapter = new ThemeAdapter(getContext(), data);
//
//            recyclerView.setAdapter(adapter);
////            RxRecyclerView.scrollEvents()
//        }
//
//        public Context getContext() {
//            return mContext;
//        }
//
//    }

    private static class TAdapter extends ArrayAdapter<Theme> {

        private int mTextId;

        public TAdapter(Context context, int resource, int textViewResourceId, List<Theme> objects) {
            super(context, resource, textViewResourceId, objects);
            this.mTextId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Theme theme = getItem(position);
            View view = super.getView(position, convertView, parent);
            CheckedTextView textView = (CheckedTextView) view.findViewById(mTextId);
            MDTintHelper.setTint(textView, getContext().getResources().getColor(theme.color));
            textView.setTextColor(getContext().getResources().getColor(theme.color));
//            textView.setChecked(convertView.getiss);
//            textView.setChecked(true);
            return view;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }

    private static String getString(int resid) {
        return HostApp.getInstance().getString(resid);
    }

}
