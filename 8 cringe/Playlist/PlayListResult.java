package Playlist;

public class PlayListResult {

    private final boolean success;
    private final String message;

    static final String ADD_FAIL_MESSAGE        = "Трек не был добавлен.";
    static final String ADD_SUCCESS_MESSAGE     = "Трек был успешно добавлен.";
    static final String DELETE_FAIL_MESSAGE     = "Трек не был удален.";
    static final String DELETE_SUCCESS_MESSAGE  = "Трек был успешно удален.";
    static final String UPDATE_FAIL_MESSAGE     = "Трек не был обновлен.";
    static final String UPDATE_SUCCESS_MESSAGE  = "Трек был успешно обновлен.";
    static final String GET_FAIL_MESSAGE        = "Трек не был найден.";
    static final String GET_SUCCESS_MESSAGE     = "Название трека по переданому индексу: ";


    public PlayListResult(boolean success,
                          String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public PlayListResult log() {
        System.out.println(message);
        return this;
    }

}
