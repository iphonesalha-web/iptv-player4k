package com.iptv.player4k.data.remote.m3u

class M3uParser {

    fun parse(content: String): List<M3uChannel> {
        val result = mutableListOf<M3uChannel>()
        val lines = content.lines()

        var currentName = ""
        var currentLogo = ""
        var currentGroup = ""
        var currentTvgId = ""

        for (line in lines) {
            val trimmed = line.trim()

            if (trimmed.startsWith("#EXTINF")) {
                currentLogo = extractAttribute(trimmed, "tvg-logo") ?: ""
                currentGroup = extractAttribute(trimmed, "group-title") ?: ""
                currentTvgId = extractAttribute(trimmed, "tvg-id") ?: ""
                currentName = trimmed.substringAfterLast(",").trim()
            } else if (trimmed.isNotEmpty() && !trimmed.startsWith("#")) {
                result.add(
                    M3uChannel(
                        name = currentName.ifBlank { "Unknown Channel" },
                        url = trimmed,
                        logo = currentLogo,
                        group = currentGroup,
                        tvgId = currentTvgId
                    )
                )
                currentName = ""
                currentLogo = ""
                currentGroup = ""
                currentTvgId = ""
            }
        }

        return result
    }

    private fun extractAttribute(line: String, key: String): String? {
        val regex = Regex("""$key=\"([^\"]*)\"""")
        return regex.find(line)?.groupValues?.getOrNull(1)
    }
}
