while (<>) {
    print if / \( ([^()])+ \) /
}