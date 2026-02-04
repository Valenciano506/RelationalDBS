package relationaldbs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @author Valenciano
 * 4 feb 2026
 */
public class LoggingTest {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LoggingTest.class);
		logger.trace(null);
		logger.debug(null);
		logger.info("");
		logger.warn(null);
		logger.error(null);
	}

}
