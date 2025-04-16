package com.bivashy.lamp.telegram.dispatch;

import com.bivashy.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.User;

public class CallbackQueryDispatchSource implements DispatchSource {
	private final CallbackQuery callbackQuery;

	public CallbackQueryDispatchSource(CallbackQuery callbackQuery) {
		this.callbackQuery = callbackQuery;
	}

	@Override
	public String getText() {
		return callbackQuery.data();
	}

	@Override
	public String getExecutionText() {
		return callbackQuery.data();
	}

	@Override
	public User getAuthor() {
		return callbackQuery.from();
	}

	@Override
	public Identificator getSourceIdentificator() {
		return Identificator.of(callbackQuery.id());
	}

	@Override
	public Identificator getChatIdentficator() {
		if (callbackQuery.message() != null)
			return Identificator.of(callbackQuery.message().chat().id());
		return null;
	}

	public CallbackQuery getCallbackQuery() {
		return callbackQuery;
	}
}
