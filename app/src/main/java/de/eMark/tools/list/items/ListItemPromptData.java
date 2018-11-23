package de.eMark.tools.list.items;

import de.eMark.R;
import de.eMark.tools.list.ListItemData;
import de.eMark.tools.manager.PromptManager;

public class ListItemPromptData extends ListItemData
{
    public final PromptManager.PromptItem promptItem;

    public ListItemPromptData(PromptManager.PromptItem aPromptItem)
    {
        super(R.layout.list_item_prompt);
        this.promptItem = aPromptItem;
    }
}
