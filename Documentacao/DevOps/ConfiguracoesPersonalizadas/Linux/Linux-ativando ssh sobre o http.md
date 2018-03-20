If you are able to SSH into git@ssh.github.com over port 443, you can override your SSH settings to force any connection to GitHub to run though that server and port.

To set this in your ssh config, edit the file at ~/.ssh/config, and add this section:

Host github.com
  Hostname ssh.github.com
  Port 443

You can test that this works by connecting once more to GitHub:

ssh -T git@github.com
Hi username! You've successfully authenticated, but GitHub does not
provide shell access.
