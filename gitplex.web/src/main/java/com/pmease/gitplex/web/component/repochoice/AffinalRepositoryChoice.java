package com.pmease.gitplex.web.component.repochoice;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.model.IModel;

import com.pmease.commons.wicket.component.select2.Select2Choice;
import com.pmease.gitplex.core.model.Repository;

@SuppressWarnings("serial")
public class AffinalRepositoryChoice extends Select2Choice<Repository> {

	/**
	 * Constructor with model.
	 * 
	 * @param id
	 * 			component id of the choice
	 * @param currentRepoId
	 * 			id of current repository from which to calculate comparable repositories.
	 * @param selectedRepoModel
	 * 			model of selected repository
	 */
	public AffinalRepositoryChoice(String id, Long currentRepoId, IModel<Repository> selectedRepoModel) {
		super(id, selectedRepoModel, new AffinalRepositoryChoiceProvider(currentRepoId));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		getSettings().setPlaceholder("Choose a repository...");
		getSettings().setFormatResult("gitplex.repoChoiceFormatter.formatResult");
		getSettings().setFormatSelection("gitplex.repoChoiceFormatter.formatSelection");
		getSettings().setEscapeMarkup("gitplex.repoChoiceFormatter.escapeMarkup");
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		response.render(JavaScriptHeaderItem.forReference(RepositoryChoiceResourceReference.INSTANCE));
	}

}
