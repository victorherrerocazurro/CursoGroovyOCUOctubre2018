package support

class MaxRetriesExtension {
    static void maxRetries(Integer self, Closure code) {
        assert self >= 0
        int retries = self
        Throwable e = null
        while (retries > 0) {
            try {
                code.call()
                break
            } catch (Throwable err) {
                e = err
                retries--
            }
        }
        if (retries == 0 && e) {
            throw e
        }
    }
}
