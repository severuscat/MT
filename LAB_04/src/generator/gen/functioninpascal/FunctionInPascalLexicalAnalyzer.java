package functioninpascal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionInPascalLexicalAnalyzer {
	private StringBuilder inputSB;
	private List<TokenItem> tokenPatterns = new ArrayList<>();
	private List<TokenItem> skipTokenPatterns = new ArrayList<>();
	private List<FunctionInPascalToken> tokens = new ArrayList<>();
	private List<String> tokensToString = new ArrayList<>();
	private int currentPosition = 0;

	public FunctionInPascalLexicalAnalyzer(String input) throws Exception {
		inputSB = new StringBuilder(input);

		tokenPatterns.add(new TokenItem(FunctionInPascalToken.FUNCTION,"function"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.PROCEDURE,"procedure"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.LP,"\\("));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.RP,"\\)"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.COMMA,","));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.COLON,":"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.SEMICOLON,";"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.TYPE,"integer|real|boolean|char|string"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.NAME,"[a-zA-Z][a-zA-Z0-9_]*"));
		tokenPatterns.add(new TokenItem(FunctionInPascalToken.EPS,""));

		skipTokenPatterns.add(new TokenItem(FunctionInPascalToken.SPACE,"[ \n\r]+"));
		getTokens();
	}

	public FunctionInPascalToken getCurrentToken() {
		return tokens.get(currentPosition);
 	}

	public String getCurrentTokenString() {
		return tokensToString.get(currentPosition);
	}

	public FunctionInPascalToken getNextToken() {
		return tokens.get(++currentPosition);
	}

	private void getTokens() throws Exception {
		while (!(inputSB.length() == 0)) {
			FunctionInPascalToken t = findFirstToken();
			if (t != null) {
				tokens.add(t);
			} else if (!findFirstSkipToken()) {
				throw new Exception("Not find matching with tokens.");
			}
		}
		tokens.add(FunctionInPascalToken._END);
	}

	private boolean findFirstSkipToken() {
		for (TokenItem item : skipTokenPatterns) {
			Matcher m = item.pattern.matcher(inputSB.toString());
			if (m.lookingAt()) {
				inputSB.delete(0, m.end());
				return true;
			}
		}
		return false;
	}

	private FunctionInPascalToken findFirstToken() {
		for (TokenItem item : tokenPatterns) {
			Matcher m = item.pattern.matcher(inputSB.toString());
			if (m.lookingAt()) {
				tokensToString.add(inputSB.substring(0, m.end()));
				inputSB.delete(0, m.end());
				return item.token;
			}
		}
		return null;
	}

	private static class TokenItem {
		FunctionInPascalToken token;
		Pattern pattern;
		TokenItem(FunctionInPascalToken token, String s) {
			this.token = token;
			pattern = Pattern.compile(s);
		}
	}
}
