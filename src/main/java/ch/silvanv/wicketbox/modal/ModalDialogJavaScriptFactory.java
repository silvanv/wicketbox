package ch.silvanv.wicketbox.modal;

public final class ModalDialogJavaScriptFactory {
    /**
     * Get the command to hide an modal dialog.
     * 
     * @param id
     *            The ID of the modal dialog
     * @return The javascript statement
     */
    public static String jsModalDialogHideCommand(String id) {
        return "$('#" + id + "').modal('hide')";
    }

    /**
     * Get the command to show an modal dialog.
     * 
     * @param id
     *            The ID of the modal dialog
     * @return The javascript statement
     */
    public static String jsModalDialogShowCommand(String id) {
        return "$('#" + id + "').modal('show')";
    }

    private ModalDialogJavaScriptFactory() {
    }
}