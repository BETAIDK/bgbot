package dev.idan.bgbot.data.comments.object.attributes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentCodeSnippetObjectAttributesData extends CommentObjectAttributesData {

    @JsonProperty("st_diff")
    String stDiff;
}
