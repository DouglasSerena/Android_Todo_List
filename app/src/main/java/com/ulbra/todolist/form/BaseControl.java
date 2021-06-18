package com.ulbra.todolist.form;

import androidx.annotation.Nullable;

public abstract class BaseControl {
    @Nullable
    protected OnStatus handleStatus;
    @Nullable
    protected OnInvalid handleInvalid;
    @Nullable
    protected OnValid handleValid;

    public String status = "INVALID";
    public boolean valid = false, invalid = true;

    protected void changeStatus(boolean invalid) {
        if (this.invalid != invalid) {
            this.valid = !invalid;
            this.invalid = invalid;
            if (this.invalid) {
                if (this.handleInvalid != null) {
                    this.handleInvalid.onInvalid();
                }
            } else {
                if (this.handleValid != null) {
                    this.handleValid.onValid();
                }
            }
            this.status = invalid ? "INVALID" : "VALID";
            if (this.handleStatus != null) {
                this.handleStatus.onStatus(this.status);
            }
        }
    }

    public void onStatus(OnStatus onStatus) {
        this.handleStatus = onStatus;
    }

    public void onValid(OnValid onValid) {
        this.handleValid = onValid;
    }

    public void onInvalid(OnInvalid onInvalid) {
        this.handleInvalid = onInvalid;
    }
}
