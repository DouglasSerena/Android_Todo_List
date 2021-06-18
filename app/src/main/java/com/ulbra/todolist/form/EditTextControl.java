package com.ulbra.todolist.form;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextControl extends BaseControl {
    EditText editText;
    TextView textViewError;

    private float scale;

    // VALIDATORS
    private boolean required = true;
    private String textErrorRequired = "";

    public void setRequired(boolean required, String textError) {
        this.required = required;
        this.textErrorRequired = textError;
    }

    private int maxlength = -1;
    private String textErrorMaxlength = "";

    public void setMaxLength(int maxlength, String textError) {
        this.maxlength = maxlength;
        this.textErrorMaxlength = textError;
    }

    public EditTextControl(EditText editText, TextView textViewError, float scale) {
        this.editText = editText;
        this.textViewError = textViewError;
        this.scale = scale;

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                valid(true, false);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (!hasFocus) {
                this.valid(true, false);
            }
        });
    }

    public boolean isEmpty() {
        return editText.getText().toString().length() == 0;
    }

    public void valid(boolean showMessage, boolean withFocus) {
        boolean error = false;
        if (required) {
            error = this.validRequired(showMessage, withFocus);
        }
        if (!error && maxlength > 0) {
            error = this.validMaxlength(showMessage, withFocus);
        }
        if (!error) {
            this.textViewError.setVisibility(View.INVISIBLE);
            this.textViewError.setHeight(0);
        }
        this.changeStatus(error);
    }

    boolean validRequired(boolean showMessage, boolean withFocus) {
        if (this.isEmpty()) {
            if (showMessage) {
                this.setMessage(this.textErrorRequired, withFocus);
            }
            return true;
        }
        return false;
    }

    boolean validMaxlength(boolean showMessage, boolean withFocus) {
        if (this.editText.getText().toString().length() > maxlength) {
            if (showMessage) {
                this.setMessage(this.textErrorMaxlength.replace("{{maxlength}}", String.valueOf(maxlength)), withFocus);
            }
            return true;
        }
        return false;
    }

    private void setMessage(String textError, boolean withFocus) {
        this.textViewError.setText(textError);
        this.textViewError.setVisibility(View.VISIBLE);
        this.textViewError.setHeight((int) (18 * scale));
        if (withFocus) {
            this.editText.requestFocus();
        }
    }
}
