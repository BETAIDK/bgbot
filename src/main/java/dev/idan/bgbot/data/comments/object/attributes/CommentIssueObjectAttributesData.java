package dev.idan.bgbot.data.comments.object.attributes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentIssueObjectAttributesData extends CommentObjectAttributesData {

    @JsonProperty("st_diff")
    String stDiff;
}
