package com.ulbra.todolist.form;


public class FormControl extends BaseControl {
    EditTextControl[] listAbstractControlEditText;

    public FormControl(EditTextControl... listAbstractControlEditText) {
        this.listAbstractControlEditText = listAbstractControlEditText;
        for (EditTextControl item : listAbstractControlEditText) {
            item.onStatus((status) -> {
                this.validate();
            });
        }
    }

    private void validate() {
        boolean invalid = false;
        for (EditTextControl item : listAbstractControlEditText) {
            if (item.invalid) {
                invalid = true;
                break;
            }
        }
        this.changeStatus(invalid);
    }
}
