package de.eMark.tools.list.items;

import android.view.View;
import android.widget.ImageButton;

import de.eMark.R;
import de.eMark.presenter.customviews.BRText;
import de.eMark.tools.list.ListItemData;
import de.eMark.tools.list.ListItemViewHolder;

public class ListItemPromptViewHolder extends ListItemViewHolder
{
    private final BRText title;
    private final BRText description;
    private final ImageButton close;

    public ListItemPromptViewHolder(View anItemView, View.OnClickListener closeClickListener)
    {
        super(anItemView);

        title = anItemView.findViewById(R.id.info_title);
        description = anItemView.findViewById(R.id.info_description);
        close = anItemView.findViewById(R.id.info_close_button);
        close.setOnClickListener(closeClickListener);
    }

    @Override
    public void process(ListItemData aListItemData)
    {
        super.process(aListItemData);

        ListItemPromptData data = (ListItemPromptData) aListItemData;

        switch (data.promptItem)
        {
            case FINGER_PRINT:
                this.title.setText(R.string.Prompts_TouchId_title_android);
                this.description.setText(R.string.Prompts_TouchId_body_android);
                break;
            case PAPER_KEY:
                this.title.setText(R.string.Prompts_PaperKey_title);
                this.description.setText(R.string.Prompts_PaperKey_body);
                break;
            case UPGRADE_PIN:
                this.title.setText(R.string.Prompts_UpgradePin_title);
                this.description.setText(R.string.Prompts_UpgradePin_body);
                break;
            case RECOMMEND_RESCAN:
                this.title.setText(R.string.ReScan_header);
                this.description.setText(R.string.Prompts_RecommendRescan_body);
                break;
        }

        this.itemView.setBackgroundResource(R.drawable.tx_rounded);
    }
}
